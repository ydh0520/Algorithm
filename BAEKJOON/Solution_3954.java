package myalgo;

import java.util.Scanner;

public class Solution_3954 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 0; test_case < tc; test_case++) {
			int memSize = scan.nextInt();
			int programSize = scan.nextInt();
			int inputSize = scan.nextInt();

			int[] mem = new int[memSize];
			String programString = scan.next();

			int stack[] = new int[programSize];
			int stackpointer = 0;

			char[] program = new char[programSize];
			int[] roopIndex = new int[programSize];

			for (int i = 0; i < programSize; i++) {
				program[i] = programString.charAt(i);
				if (program[i] == '[') {
					stack[stackpointer] = i;
					stackpointer++;
				}

				if (program[i] == ']') {
					int openIndex = stack[--stackpointer];
					roopIndex[openIndex] = i;
					roopIndex[i] = openIndex;
				}

			}
			char[] input = scan.next().toCharArray();

			int programIndex = 0;
			int pointer = 0;
			int inputindex = 0;

			int cmdCounter = 50000000;
			while (cmdCounter >= 0) {

				switch (program[programIndex]) {
				case '-':
					mem[pointer] = (mem[pointer] - 1) % 256;
					programIndex++;
					break;
				case '+':
					mem[pointer] = (mem[pointer] + 1) % 256;
					programIndex++;
					break;
				case '<':
					pointer = (pointer + memSize - 1) % mem.length;
					programIndex++;
					break;
				case '>':
					pointer = (pointer + 1) % mem.length;
					programIndex++;
					break;
				case '[':
					if (mem[pointer] == 0) {
						programIndex = roopIndex[programIndex];
					} else {
						programIndex++;
					}
					break;
				case ']':
					if (mem[pointer] != 0) {
						programIndex = roopIndex[programIndex];
					} else {
						programIndex++;
					}
					break;
				case '.':
					programIndex++;
					break;
				case ',':
					if (inputindex < input.length) {
						mem[pointer] = input[inputindex];
						inputindex++;
					} else
						mem[pointer] = 255;
					programIndex++;
					break;
				}

				if (programIndex >= program.length)
					break;
				cmdCounter--;
			}

			if (cmdCounter >= 0) {
				System.out.println("Terminates");
			} else {
				int roopstart = 0;
				while (roopstart < programIndex) {
					if (roopIndex[roopstart] >= programIndex) {
						break;
					}
					roopstart++;
				}

				System.out.println(String.format("Loops %d %d", roopstart, roopIndex[roopstart]));
			}
		}
	}
}
