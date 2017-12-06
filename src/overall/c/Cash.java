package overall.c;

public class Cash {
	public int kind;
	public int stock;
	Cash(int kind, int stock) {
		this.kind = kind;
		this.stock = stock;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return this.kind + "円：" + this.stock + "枚";
	}

	public void increase(int count) {
		this.stock += count;
	}

	public void reduce(int count) {
		this.stock -= count;
	}
}
