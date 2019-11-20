package com.wirk.demo.play;

import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Mao LuDong
 * @date : Created in 16:47 2019/11/1
 */
public class Sudoku {

  public static void main(String[] args) {
    new Tool("E:\\test\\data.txt").deal();
  }
}

class Tool {
  private Integer[][] data = new Integer[9][9];
  private Integer[][] originalData = new Integer[9][9];
  private String fileUrl;
  private List<Possible> originalPossibleValue = null;
  private double startTime;

  Tool(String fileUrl) {
    this.fileUrl = fileUrl;
    readData();
  }

  void deal() {
    printOriginalData();
    startTime = System.currentTimeMillis();
    if (!easyDeal()) {
      complexDeal();
    } else {
      printCurData("解出！");
    }
  }

  private void complexDeal() {
    Stack<Exclude> stack = new Stack<>();
    List<Possible> possibleValue = getPossibleValue();
    possibleValue.sort(new Possible());
    Possible poss = possibleValue.get(0);
    stack.push(new Exclude(poss));
    stack.peek().setSuData(copySuData(this.data));
    this.data[poss.getRow()][poss.getCol()] = poss.getPossValue().get(0);
    if (complexDealHandler(stack)) {
      double endTime = System.currentTimeMillis();
      printCurData("解出，用时：" + (endTime - startTime) + " ms");
    } else {
      printCurData("解出失败！");
    }
  }

  private boolean complexDealHandler(Stack<Exclude> stack) {
    for (; ; ) {
      if (!checkError()) {
        Exclude peek = stack.peek();
        if (peek.nextValue()) {
          this.data = copySuData(peek.getSuData());
          this.data[peek.getRow()][peek.getCol()] = peek.getCurValue();
        } else if (stack.size() == 1) {
          return false;
        } else {
          stack.pop();
        }
      } else {
        List<Possible> poss = getPossibleValue();
        poss.sort(new Possible());
        if (this.fillIn(poss)) {
          if (dealCompleted()) {
            return true;
          }
        } else {
          if (poss.size() > 0) {
            Possible possible = poss.get(0);
            stack.push(new Exclude(possible));
            stack.peek().setSuData(copySuData(this.data));
            this.data[possible.getRow()][possible.getCol()] = possible.getPossValue().get(0);
          }
        }
      }
    }
  }

  private boolean easyDeal() {
    List<Possible> poss = getPossibleValue();
    while (fillIn(poss)) {
      poss = getPossibleValue();
    }
    return dealCompleted();
  }

  private Integer[][] copySuData(Integer[][] src) {
    Integer[][] copy = new Integer[9][9];
    for (int i = 0; i < src.length; i++) {
      System.arraycopy(src[i], 0, copy[i], 0, 9);
    }
    return copy;
  }

  private FileInputStream readFile() {
    File file = new File(this.fileUrl);
    try {
      return new FileInputStream(file);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  private void readData() {
    FileInputStream fs = readFile();
    byte[] data = new byte[100];
    try {
      if (fs != null) {
        fs.read(data);
      } else {
        System.out.println("文件读取失败！");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    String s = new String(data).replaceAll("\\s", "").substring(0, 81).replaceAll("\\D", "0");
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int d = Integer.parseInt(String.valueOf(chars[i]));
      this.data[i / 9][i % 9] = d;
      this.originalData[i / 9][i % 9] = d;
    }
  }

  private void printOriginalData() {
    System.out.println("| 读取数据为： |");
    printTwoDimensionalArray(this.originalData);
  }

  private void printCurData(String text) {
    if (text == null) {
      text = "当前数据为：";
    }
    System.out.println("| " + text + " |");
    printTwoDimensionalArray(this.data);
  }

  private void printTwoDimensionalArray(Integer[][] data) {
    System.out.println("---------------------------");
    for (Integer[] datum : data) {
      String s = Arrays.toString(datum);
      System.out.println(s);
    }
    System.out.println("---------------------------");
  }

  private Integer[] getCol(Integer ind) {
    Integer[] data = new Integer[9];
    for (int i = 0; i < 9; i++) {
      data[i] = this.data[i][ind];
    }
    return data;
  }

  private List<Possible> getPossibleValue() {
    List<Possible> data = new ArrayList<>(81);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (this.data[i][j].equals(0)) {
          SingleTest sin = getSingleTest(i, j);
          Possible possible = new Possible(i, j, sin.getCanFillIn());
          if (possible.getPossValue().size() > 0) {
            data.add(possible);
          }
        }
      }
    }
    if (originalPossibleValue == null) {
      originalPossibleValue = data;
    }
    return data;
  }

  private boolean fillIn(List<Possible> p) {
    if (p.size() < 1) {
      return false;
    }
    p.sort(new Possible());
    boolean data = false;
    for (Possible possible : p) {
      if (possible.canFillIn()) {
        this.data[possible.getRow()][possible.getCol()] = possible.getPossValue().get(0);
        data = true;
      }
    }
    return data;
  }

  private int get3x3Index(Pair<Integer, Integer> pair) {
    return pair.getKey() / 3 * 3 + pair.getValue() / 3;
  }

  private Integer[] get3x3ToArray(int index) {
    Integer[] res = new Integer[9];
    int colInd = index % 3 * 3;
    Integer rowInd = index / 3 * 3;
    for (Integer i = 0; i < 3; i++) {
      Integer[] ints = Arrays.copyOfRange(this.data[rowInd + i], colInd, colInd + 3);
      System.arraycopy(ints, 0, res, i * 3, 3);
    }
    return res;
  }

  private boolean checkError() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        SingleTest st = getSingleTest(i, j);
        if ((this.data[i][j].equals(0) && st.getCanFillIn().size() < 1) || !st.test()) {
          return false;
        }
      }
    }
    return true;
  }

  private SingleTest getSingleTest(int row, int col) {
    return new SingleTest(
        this.data[row], getCol(col), get3x3ToArray(get3x3Index(new Pair<>(row, col))));
  }

  private boolean dealCompleted() {
    boolean ok;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        ok = getSingleTest(i, j).test() && !this.data[i][j].equals(0);
        if (!ok) {
          return false;
        }
      }
    }
    return true;
  }
}

class Exclude extends Possible {
  private List<Integer> exclude;
  private Integer curValue;
  private Integer[][] suData;

  Exclude(Possible poss) {
    super(poss.getRow(), poss.getCol(), poss.getPossValue());
    this.exclude = new LinkedList<>();
    this.curValue = poss.getPossValue().get(0);
  }

  private boolean allExclude() {
    if (this.exclude.size() >= this.getPossValue().size()) {
      boolean res = true;
      for (Integer integer : this.exclude) {
        if (!this.getPossValue().contains(integer)) {
          res = false;
          break;
        }
      }
      return res;
    } else {
      return false;
    }
  }

  boolean nextValue() {
    exclude.add(curValue);
    if (this.allExclude()) {
      return false;
    } else {
      Integer integer = null;
      try {
        integer = this.getPossValue().get(this.getPossValue().indexOf(curValue) + 1);
      } catch (Exception e) {
        System.out.println(this.getPossValue());
        System.out.println(this.getExclude());
        System.out.println(curValue);
      }
      curValue = integer;
      return true;
    }
  }

  private List<Integer> getExclude() {
    return exclude;
  }

  Integer getCurValue() {
    return curValue;
  }

  Integer[][] getSuData() {
    return suData;
  }

  void setSuData(Integer[][] suData) {
    this.suData = suData;
  }

  @Override
  public String toString() {
    return "Exclude{" + "exclude=" + exclude + ", curValue=" + curValue + "} " + super.toString();
  }
}

class Possible implements Comparator<Possible> {
  private Pair<Integer, Integer> index;
  private List<Integer> possValue;

  Possible() {}

  Possible(int row, int col, List<Integer> possValue) {
    this.index = new Pair<>(row, col);
    this.possValue = possValue;
  }

  List<Integer> getPossValue() {
    return possValue;
  }

  @Override
  public int compare(Possible o1, Possible o2) {
    return o1.getPossValue().size() - o2.getPossValue().size();
  }

  boolean canFillIn() {
    return this.getPossValue().size() == 1;
  }

  int getRow() {
    return this.index.getKey();
  }

  int getCol() {
    return this.index.getValue();
  }

  @Override
  public String toString() {
    return "\nPossible{"
        + "index=("
        + index.getKey()
        + ","
        + index.getValue()
        + "), possValue="
        + possValue
        + "}";
  }
}

class SingleTest {
  private Integer[] row;
  private Integer[] col;
  private Integer[] block;

  SingleTest(Integer[] row, Integer[] col, Integer[] block) {
    this.row = row;
    this.col = col;
    this.block = block;
  }

  private List<Integer> getAn() {
    return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
  }

  List<Integer> getCanFillIn() {
    List<Integer> res = getAn();
    res.removeAll(Arrays.asList(this.row));
    res.removeAll(Arrays.asList(this.col));
    res.removeAll(Arrays.asList(this.block));
    return res;
  }

  boolean test() {
    List<Integer> rowList = new ArrayList<>(Arrays.asList(this.row));
    rowList.removeAll(Collections.singletonList(0));
    List<Integer> colList = new ArrayList<>(Arrays.asList(this.col));
    colList.removeAll(Collections.singletonList(0));
    List<Integer> blockList = new ArrayList<>(Arrays.asList(this.block));
    blockList.removeAll(Collections.singletonList(0));
    return new HashSet<>(rowList).size() == rowList.size()
        && new HashSet<>(colList).size() == colList.size()
        && new HashSet<>(blockList).size() == blockList.size();
  }

  @Override
  public String toString() {
    return "SingleTest{"
        + "row="
        + Arrays.toString(row)
        + ", col="
        + Arrays.toString(col)
        + ", block="
        + Arrays.toString(block)
        + '}';
  }
}
