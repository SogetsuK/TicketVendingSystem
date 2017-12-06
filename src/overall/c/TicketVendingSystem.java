package overall.c;

public class TicketVendingSystem {
	private static CashSet wallet = new CashSet(5);

	public static void main(String[] args) {
		while(true) {
			int i = select();
			int j = deposit(i);
			printChange(j);
		}
	}
	
	private static Station[] getStationList() {
		Station[] list = new Station[3];
		list[0] = new Station("秋葉原", 133);
		list[1] = new Station("山梨", 4128);
		list[2] = new Station("長野", 7990);
		return list;
	}

	private static int select() {
		System.out.println("【ウチダ電鉄 券売機システム】\r");
		Station[] stationList = getStationList();
		System.out.println("財布の中身");
		wallet.show(false);
		System.out.println("駅の選択");
		for(int i = 0; i < stationList.length; i++) {
			System.out.println(i + 1 +":" + stationList[i].toString());

		}
		System.out.println("行き先を入力してください（終了する場合には0を入力）");
		int a = Input.nextInt(0, stationList.length);
		if(a == 0) {
			System.out.println("システムを終了します");
			System.exit(0);
		}
		Station b = stationList[a - 1];
		System.out.println("行き先は" + b.getName() + "で料金は" + b.getFare() + "円です");
		return b.getFare();
	}

	private static int deposit(int fare) {
		System.out.println("紙幣・硬貨を投入してください");
		int a = 0;
		do {
			System.out.println("\r●投入する紙幣・硬貨を選択してください");
			System.out.println("あと【" + (fare - a) + "円】です");
			System.out.println("\r財布の中身");
			wallet.show(true);
			Cash b;
			while(true) {
				int i = Input.nextInt(1, 7);
				b = wallet.getCashByIndex(i-1);
				if(b.getStock() != 0){
					break;
				}
				System.out.println(b.getKind() + "円の在庫がありません");
			}
			System.out.println(b.getKind() + "円を何枚投入しますか");
			int j = Input.nextInt(1, b.stock);
			a += b.getKind() * j;
			wallet.pay(b.getKind(), j);
			System.out.println("現在の投入金額は【" + a + "円】です");
		}while(a < fare);
		return a - fare;
	}

	private static void printChange(int change) {
		CashSet a = changeDetail(change);
		System.out.println("購入が完了しました\nお釣りは以下の通りです\n●お釣りの明細");
		a.show(false);
		wallet.add(a);
		System.out.println();
	}

	private static CashSet changeDetail(int total){
		CashSet a = new CashSet();
		for(int kind : Money.kinds) {
			int count = total / kind;
			a.add(kind , count);
			total -= kind * count;
		}
		return a;
	}
}

