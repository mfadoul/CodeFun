package examples.ackermann;

import java.util.HashMap;
import java.util.Map;

public class Ackermann {

	public static long ackermann(long m, long n) {

		AckermannKey ackermannKey = new AckermannKey(m, n);
		if (ackermannMap.containsKey(ackermannKey)) {
			++usedCacheCount;
			return ackermannMap.get(ackermannKey);
		}

		if (m == 0) {
			// Register new key/value pair
			long ackermannValue = n + 1;
			ackermannMap.put(ackermannKey, ackermannValue);
			// System.out.println(" Registering: Value of " + ackermannKey + " =
			// " + ackermannValue);
			return ackermannValue;
		}

		if (n == 0) {
			return ackermann(m - 1, 1);
		}

		// This line is the reason that the process will have a stack overflow, even with caching.
		return ackermann(m - 1, ackermann(m, n - 1));
	}

	public static void main(String[] args) {
		long finalM = 5;
		long finalN = 1000000;

		long answer;
		long beginTime;
		long endTime;

		for (int m = 0; m < finalM; ++m) {
			for (int n = 0; n < finalN; ++n) {
				System.out.print("Trying Ackermann value of (" + m + ", " + n + ") = ");
				beginTime = System.currentTimeMillis();
				answer = ackermann(m, n);
				endTime = System.currentTimeMillis();
				System.out.println(answer + ". " + "Time= "
						+ (endTime - beginTime) + " milliseconds. " + "Map size = " + ackermannMap.size()
						+ ". Cache use = " + usedCacheCount);
			}
		}
	}

	static Map<AckermannKey, Long> ackermannMap = new HashMap<AckermannKey, Long>();

	// Number of times the cache was used:
	static long usedCacheCount = 0;

}
