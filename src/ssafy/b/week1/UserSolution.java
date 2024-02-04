package ssafy.b.week1;

class UserSolution {

    private Soldier head;
    private Soldier tail;

    private int size;

    public void init() {
        head = null;
        tail = null;
        size = 0;
    }

    public void hire(int mID, int mTeam, int mScore) {
        Soldier first = head;

        Soldier newSoldier = new Soldier(mID, mTeam, mScore, first);

        head = newSoldier;

        size += 1;

        if (first == null) {
            tail = newSoldier;
        }
    }

    public void fire(int mID) {
		Soldier prev = head;

		if (prev.mID == mID) {
			removeFirst();
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			if (prev.next.mID == mID) {
				break;
			}
			prev = prev.next;
		}

		Soldier fireSoldier = prev.next;

		Soldier nextSoldier = fireSoldier.next;

		//해고 대상이 테일인 경우
		if (nextSoldier == null) {

		}

		prev.next = null;

		fireSoldier.removeInfo();

		prev.next = nextSoldier;
		size -= 1;
    }

    public void updateSoldier(int mID, int mScore) {
		Soldier s = head;
		for (int i = 0; i < size; i++) {
			if (s.mID == mID) {
				break;
			}
			s = s.next;
		}

		s.reputaion = mScore;
    }

    public void updateTeam(int mTeam, int mChangeScore) {
		Soldier soldier = head;
		for (int i = 0; i < size; i++) {
			if (soldier.team == mTeam) {
				if (soldier.reputaion + mChangeScore > 5) {
					soldier.reputaion = 5;
				} else if (soldier.reputaion + mChangeScore < 1) {
					soldier.reputaion = 1;
				} else {
					soldier.reputaion = soldier.reputaion + mChangeScore;
				}
			}
		}
    }

    public int bestSoldier(int mTeam) {
		Soldier soldier = head;

		int best = Integer.MIN_VALUE;
		int mId = -1;
		for (int i = 0; i < size; i++) {
			if (soldier.team == mTeam) {
				if (best <= soldier.reputaion && mId < soldier.mID) {
					best = soldier.reputaion;
					mId = soldier.mID;
				}
			}

			soldier = soldier.next;
		}

        return mId;
    }

	private void removeFirst() {
		Soldier s = head;
		if (tail == s) {
			init();
			return;
		}

        head = s.next;

		s.removeInfo();

		size -= 1;
	}

	private void removeLast() {
		Soldier s = tail;


	}

    private static class Soldier {

        private int mID;
        private int team;
        private int reputaion;

        private Soldier next;

        public Soldier(int mID, int team, int reputaion, Soldier next) {
            this.mID = mID;
            this.team = team;
            this.reputaion = reputaion;
            this.next = next;
        }

		public void removeInfo() {
			this.mID = -1;
			this.team = -1;
			this.reputaion = -1;
			next = null;
		}
    }
}