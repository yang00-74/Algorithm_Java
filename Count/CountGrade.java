package Count;

import java.util.Map;
import java.util.Scanner;

public class CountGrade {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		float[] magic = new float[len];
		float[] grade = new float[len];
		for (int i = 0; i < len; i++) {
			grade[i] = scanner.nextInt();
		}
		for (int i = 0; i < len; i++) {
			magic[i] = scanner.nextInt();
		}
		int limit = scanner.nextInt();
		System.out.println(countGrade(magic, grade, limit));
	}

	public static int countGrade(float[] magic, float[] grade, int limit) {
		int len = magic.length;
		float[] rate = new float[len];
		for (int i = 0; i < len; i++) {
			rate[i] = grade[i] / magic[i];
		}
		int count = 0;
		int score = 0;
		while (!allZeroInArray(rate)) {
			int k = 0;
			float max = 0;
			for (int j = 0; j < len; j++) {
				if (rate[j] > max) {
					max = rate[j];
					k = j;
				} else if (rate[j] == max) {
					if (grade[j] > grade[k] && count + magic[j] <= limit) {
						k = j;
					}
				}
			}
			count += magic[k];
			if (count > limit) {
				break;
			}
			score += grade[k];
			rate[k] = 0;
		}
		return score;
	}

	public static boolean allZeroInArray(float[] rate) {
		for (int i = 0; i < rate.length; i++) {
			if (rate[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
