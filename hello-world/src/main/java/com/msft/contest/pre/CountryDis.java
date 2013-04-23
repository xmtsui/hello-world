package com.msft.contest.pre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountryDis {
	public static double distanceCal(double x1, double y1, double x) {
		double dis = 0;
		dis = java.lang.Math.sqrt((x1 - x) * (x1 - x) + (y1 - 0) * (y1 - 0));
		return dis;
	}

	public static double[] insertSort(double[] elements) {
		for (int i = 1; i < elements.length; i++) {
			int j = -1;
			while (j < i && elements[i] > elements[++j])
				;
			if (j < i) {
				double temp = elements[i];
				for (int k = i - 1; k >= j; k--) {
					elements[k + 1] = elements[k];
				}
				elements[j] = temp;
			}
		}
		double[] return_min_max = new double[2];
		return_min_max[0] = elements[0];
		return_min_max[1] = elements[elements.length - 1];
		return return_min_max;
	}

	public static void main(String[] args) {

		Scanner sin = new Scanner(System.in);
		String s_group = sin.nextLine();
		int group = new Integer(s_group);

		int gi = 0;

		int[] cn = new int[group];// country number

		List<Map<Double, Double>> gacc = new ArrayList<Map<Double, Double>>();// all
																				// group
																				// country
																				// coordinate

		while (gi < group) {
			cn[gi] = new Integer(sin.nextLine());
			double i = 0;
			Map<Double, Double> acc = new HashMap<Double, Double>();// all
																	// country
																	// coordinate
			while (i < cn[gi]) {
				String tmp = sin.nextLine();
				String[] tmp_ = tmp.split(" ");
				double[] cc = new double[2];
				cc[0] = new Double(tmp_[0]);
				cc[1] = new Double(tmp_[1]);
				acc.put(cc[0], cc[1]);
				i++;
			}
			gacc.add(acc);
			gi++;
		}

		gi = 0;
		while (gi < group) {
			Set<Double> si = gacc.get(gi).keySet();
			Iterator<Double> i = si.iterator();
			double[] sort = new double[si.size()];
			int ind = 0;
			while (i.hasNext()) {
				// double tmp = i.next();
				// System.out.println(tmp + " " + gacc.get(0).get(tmp));
				sort[ind] = i.next();
				ind++;
			}
			double[] return_min_max = insertSort(sort);

			double min_d = return_min_max[0];
			double max_d = return_min_max[1];
			int min = new Double(min_d).intValue();
			int max = new Double(max_d).intValue();
			int step = max - min;

			// System.out.println("smallest: " + return_min_max[0]);
			// System.out.println("biggest: " + return_min_max[1]);
			// System.out.println("dis: " + distanceCal(0,8,));

			// Iterator<Double> ii = si.iterator();
			Map<Double, Double> res = new HashMap<Double, Double>();

			for (int t = min; t < max; t++) {
				double[] res_tmp = new double[cn[gi]];
				int index = 0;
				i = si.iterator();
				while (i.hasNext()) {
					double tmp = i.next();

					res_tmp[index] = distanceCal(tmp, gacc.get(gi).get(tmp), t);
					// System.out.println("dis" + (t-min) + ": " +
					// res_tmp[index]);
					index++;
				}
				// res[t-min] = insertSort(res_tmp)[1];
				res.put(insertSort(res_tmp)[1], new Double(t));
				// System.out.println("dis max" + (t-min) + ": " + res.get(new
				// Double(t-min)));
			}
			double[] res_sort = new double[step];
			int q = 0;
			while (q < step) {
				Set<Double> kk = res.keySet();
				Iterator<Double> kki = kk.iterator();
				while (kki.hasNext()) {
					res_sort[q] = new Double(kki.next().toString());
				}
				q++;
			}
			BigDecimal bd = new BigDecimal(res.get(insertSort(res_sort)[0]));
			bd.setScale(6);
			System.out.println("Case #" + (gi + 1) + ": " + bd.setScale(6));

			gi++;
		}

	}// end of main
}// end of class