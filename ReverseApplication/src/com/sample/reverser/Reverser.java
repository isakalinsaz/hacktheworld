package com.sample.reverser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Reverser {
	
	static List<String> reversedList=new ArrayList<String>();
	
	public static void main(String[] args) {
		String strContent = "";
		String str = "";
		File file = new File("D:\\sample\\reverse.txt");
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), "UTF8"));
			while ((str = in.readLine()) != null) {

				readAndReverseWords(str);
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (in.readLine() != null) {
					in.close();
				}
				
				writeToFile();
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

	public static void readAndReverseWords(String str) throws IOException {
		char[] specialChars = { '.', ',', ' ', ':', '\'' };

		// Metni ve special karakterleri istediğin gibi verebilirsiniz, her
		// türlü parse edecektir.
		// String str =
		// "EURO 2016'daki kader maçında Çek Cumhuriyeti ile karşılaşacak A Milli Takımımız'ın 2. tura çıkabilmesi için, Çek Cumhuriyeti'ni 2 farklı yenmesi ve diğer maçlardaki birçok ihtimalin gerçekleşmesi gerekiyor. Peki Türkiye gruptan nasıl çıkar";
		char[] temStr = str.toCharArray();
		String tempChars = "";

		boolean isSpecialChar = false;
		int startIndex = -1, position = 0;
		List<Reverse> r = new ArrayList<Reverse>();

		for (int i = 0; i < str.length(); i++) {

			for (int j = 0; j < specialChars.length; j++) {
				if (str.charAt(i) == specialChars[j]) {
					isSpecialChar = true;
					break;
				}
			}

			if (!isSpecialChar) {
				tempChars += "" + str.charAt(i);
			} else {

				String reversedWord = str.substring(startIndex + 1, position);
				reversedWord = new StringBuilder(reversedWord).reverse()
						.toString();
				// System.out.println(reversedWord);
				Reverse reverse = new Reverse();
				reverse.setStartIndex(startIndex + 1);
				reverse.setEndIndex(position);
				reverse.setWord(reversedWord);
				r.add(reverse);

				startIndex = position;
				tempChars = "";
			}

			position++;
			isSpecialChar = false;

		}

		for (int i = 0; i < r.size(); i++) {
			System.out.println("Word:" + r.get(i).getWord() + " Start:"
					+ r.get(i).getStartIndex() + " End:"
					+ r.get(i).getEndIndex());
		}

		for (int i = 0; i < temStr.length; i++) {
			for (int j = 0; j < r.size(); j++) {
				if (j % 2 == 1) {
					if (i == r.get(j).getStartIndex()) {
						int counter = 0;
						for (int j2 = r.get(j).getStartIndex(); j2 < r.get(j)
								.getEndIndex(); j2++) {
							boolean specialCharUsed = false;
							for (int k = 0; k < specialChars.length; k++) {
								if (specialChars[k] == r.get(j).getWord()
										.charAt(counter)) {
									specialCharUsed = true;
									break;
								}
							}
							if (specialCharUsed)
								break;
							temStr[j2] = r.get(j).getWord().charAt(counter);
							counter++;
						}
						break;
					}
				}
			}
		}

		System.out.println(temStr);
		reversedList.add(String.copyValueOf(temStr));
		
	}

	
	
	public static String file = "D:\\sample\\reversed.txt";

	public static void writeToFile() throws IOException {

		File fout = new File(file);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for (String reverseWords : reversedList) {
			bw.write(reverseWords);
			bw.newLine();
		}
		
		bw.close();
		System.out.println("Reverse işlemi sona erdi.");

	}

}
