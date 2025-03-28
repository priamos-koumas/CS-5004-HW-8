package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class GameCommandReader {

private String [] data;
private Readable in;
private Appendable out;

public GameCommandReader() {
  this.in = new InputStreamReader(System.in);
  this.out = System.out;
  this.data = new String[3];
}

public GameCommandReader(Readable in, Appendable out) {
  this.in = in;
  this.out = out;
  this.data = new String[3];
}

public boolean getDataFromUser() {
  try {
    Scanner scanner = new Scanner(this.in);
    this.out.append("Format: operator operand_1 operand_2 or Q to quit: ");
    for (int i = 0; i < 3; i ++) {
     if (scanner.hasNext()) {
       this.data[i] = scanner.next();
     }
     if (this.data[0].equalsIgnoreCase("Q")) {
       return false;
     }

   }
   return true;
  }
  catch (IOException e) {
    e.printStackTrace();
  }
  return false;
}

 public String getOperator() {
	  return this.data[0];
	}

 public double getOperand1() {
	  return Double.parseDouble(this.data[1]);
	}

 public double getOperand2() {
	  return Double.parseDouble(this.data[2]);
	}

 public static void main(String[] args) {

/*
  GameCommandReader reader = new CalculatorCommandReader();
  while (reader.getDataFromUser()) {
    System.out.println("Operator = " + reader.getOperator());
	System.out.println("Operand 1 = " + reader.getOperand1());
	System.out.println("Operand 2 = " + reader.getOperand2());

 */

   String s = " + 100 200\n- 1 1 \nQ\n";
   BufferedReader stringReader =
           new BufferedReader(new StringReader(s)); // source / input

   StringBuffer sb = new StringBuffer(); // output

   GameCommandReader reader =
           new GameCommandReader(stringReader, sb);

  reader.getDataFromUser();
  System.out.println(sb);
  System.out.println(reader.getOperator());
  System.out.println(reader.getOperand1());
  System.out.println(reader.getOperand2());

  }
}

