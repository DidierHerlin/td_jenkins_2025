package Money;


import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<>();

    public MoneyBag(Money m1, Money m2) {
        System.out.println("Cr�ation MoneyBag avec 2 Money : " + m1 + ", " + m2);
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money[] bag) {
        System.out.print("Cr�ation MoneyBag avec tableau: ");
        for (Money m : bag) System.out.print(m + " ");
        System.out.println();
        for (Money m : bag) {
            appendMoney(m);
        }
    }

    private void appendMoney(Money m) {
        System.out.println("appendMoney appel� avec: " + m);
        for (int i = 0; i < fMonies.size(); i++) {
            Money existing = fMonies.get(i);
            if (existing.currency().equals(m.currency())) {
                System.out.println("Fusion avec: " + existing);
                fMonies.set(i, new Money(existing.amount() + m.amount(), m.currency()));
                return;
            }
        }
        fMonies.add(m);
    }

    @Override
    public IMoney add(IMoney m) {
        System.out.println("MoneyBag.add(IMoney) appel� avec: " + m);
        return ((MoneyBag) m).addMoneyBag(this);
    }

    public IMoney addMoney(Money m) {
        System.out.println("MoneyBag.addMoney(Money) appel� avec: " + m);
        MoneyBag result = new MoneyBag(this.toArray());
        result.appendMoney(m);
        return result;
    }

    public IMoney addMoneyBag(MoneyBag s) {
        System.out.println("MoneyBag.addMoneyBag(MoneyBag) appel�");
        MoneyBag result = new MoneyBag(this.toArray());
        for (Money m : s.toArray()) {
            result.appendMoney(m);
        }
        return result;
    }

    public Money[] toArray() {
        return fMonies.toArray(new Money[0]);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MoneyBag)) return false;
        MoneyBag other = (MoneyBag) obj;

        if (this.fMonies.size() != other.fMonies.size()) return false;

        for (Money m : this.fMonies) {
            if (!other.fMonies.contains(m)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fMonies.toString();
    }
}

