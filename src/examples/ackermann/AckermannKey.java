package examples.ackermann;

public class AckermannKey {

	public AckermannKey(long m, long n) {
		this.m = m;
		this.n = n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (m ^ (m >>> 32));
		result = prime * result + (int) (n ^ (n >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AckermannKey))
			return false;
		AckermannKey other = (AckermannKey) obj;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AckermannKey [m=" + m + ", n=" + n + "]";
	}

	final private long m;
	final private long n;
}
