package com.company.perfectworld;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 你正在玩一个RST（即时战略）游戏。此时你已经有很多队士兵，每一队里的士兵战队力相同。该游戏士兵种类以战斗力区分，既战斗力一样的士兵算作一种。
 * 你想重新调整编队，将现有的队列合并成战斗力相同的两队，请想出有多少种编队方法吧。
 * 
 * 比如：你现在有两队士兵，第一队有4个士兵，每个士兵战斗力都是1，第二队有2个士兵，每个士兵战斗力都是2.
 * 这时你有三种编队方法，可以将这些士兵合并成战斗力相同的两个队伍： 方法一：队伍1有4个战斗力为1的士兵，队伍2有2个战斗力为2的士兵，两队的战斗力都是4
 * 方法二：队伍1有2个战斗力为2的士兵，队伍2有4个战斗力为1的士兵，两队的战斗力都是4
 * 方法三：队伍1有2个战斗力为1的士兵和1个战斗力为2的士兵，队伍2有2个战斗力为1的士兵和1个战斗力为2的士兵，两队的战斗力都是4
 * 
 * @author XIAO
 *
 */
public class Formation {
	public static void main(String[] args) {
		sovle();
	}

	private static void sovle() {
		Scanner scanner = new Scanner(System.in);
		String numsL = scanner.nextLine();
		String valsL = scanner.nextLine();
		numsL = numsL.substring(1, numsL.length() - 1);
		valsL = valsL.substring(1, valsL.length() - 1);
		String[] numss = numsL.split(",");
		String[] valss = valsL.split(",");
		int num, val;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < valss.length; i++) {
			num = Integer.parseInt(numss[i].trim());
			val = Integer.parseInt(valss[i].trim());
			if (map.containsKey(val)) {
				map.put(val, num + map.get(val));
			} else {
				map.put(val, num);
			}
			sum += num * val;
		}
		if ((sum & 1) != 0) {
			System.out.println(0);
			return;
		}
		int[] nums = new int[map.size()];
		int[] vals = new int[map.size()];
		int c = 0;
		for (Entry<Integer, Integer> en : map.entrySet()) {
			nums[c] = en.getValue();
			vals[c++] = en.getKey();
		}
		long dp[][] = new long[nums.length + 1][(sum >> 1) + 1];
		dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				int cnt = j / vals[i - 1];
				for (int k = 0; k <= cnt && k <= nums[i - 1]; k++) {
					dp[i][j] += dp[i - 1][j - k * vals[i - 1]];
				}
			}
		}
		System.out.println(dp[nums.length][sum >> 1]);
	}
}
