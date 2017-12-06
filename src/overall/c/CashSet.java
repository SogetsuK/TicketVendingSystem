package overall.c;

import java.util.Random;

public class CashSet {
	private Cash[] cashes = new Cash[Money.kinds.length];

	CashSet() {
		this(0);
	}

	CashSet(int range) {
		Random a = new Random();
		for(int i = 0; i < cashes.length; i++) {
			int count = 0;
			if(range > 0) {
				count = a.nextInt(range);
			}
			Cash b = new Cash(Money.kinds[i], count);
			cashes[i] = b;
		}

	}

	public void show(boolean number) {
			System.out.println("（合計" + getTotal() + "円です）");
			for(int i = 0; i < Money.kinds.length; i++) {
				Cash a;
				a = cashes[i];
				if(number == true && a.getKind() < 10) {
					break;
				}
				if(number == true) {
					System.out.print(i + 1 + ":	");
				}
				System.out.println(cashes[i].getKind() + "円 :\t\t" + cashes[i].getStock() + "枚");
			}
			System.out.println();
	}

	 public Cash[] getCashes() {
		return cashes;
	}

	public int getTotal() {
		 int sum = 0;
		 for(Cash a : cashes) {
			 sum += a.getKind() * a.getStock();
		 }
		 return sum;
	 }

	 public Cash getCashByIndex(int index) {
		 try {
			 return cashes[index];
		 }catch(ArrayIndexOutOfBoundsException e) {
			 return null;
		 }
	 }

	 public void pay(int kind,int count) {
		 Cash a = getCashByKind(kind);
		 a.reduce(count);

	 }

	 public void add(int kind,int count) {
		 Cash a = getCashByKind(kind);
		 a.increase(count);
	 }

	 public void add(CashSet cs) {
		 for(Cash cash : cashes) {
			 Cash myCash = new Cash(cash.getKind(),cash.getStock());
			 myCash.increase(cash.getStock());
		 }

	 }

	 private Cash getCashByKind(int kind) {
		 for(Cash cash : cashes) {
			 if(cash.kind == kind) {
				 return cash;
			 }
		 }
		 return null;
	 }
}
