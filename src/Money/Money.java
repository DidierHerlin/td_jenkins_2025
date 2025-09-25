package Money;

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    /**
     * Additionne l'objet courant avec un autre IMoney.
     * @throws IllegalArgumentException si la devise est diff�rente ou si le type n'est pas support�.
     */
    @Override
    public IMoney add(IMoney m) {
        if (m == null) throw new IllegalArgumentException("Arg cannot be null");

        if (m instanceof Money) {
            Money money = (Money) m;
            if (!this.currency().equals(money.currency())) {
                throw new IllegalArgumentException("Devise incompatible : " + this.currency() + " vs " + money.currency());
            }
            return new Money(this.amount() + money.amount(), this.currency());
        }
        // Pour plus tard, dans le cas d'un MoneyBag, tu pourrais faire :
        // if (m instanceof MoneyBag) { return m.add(this); }

        // Sinon, on signale proprement le type non support�
        throw new IllegalArgumentException("Type non support� pour addition : " + m.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money other = (Money) obj;
        return this.fAmount == other.fAmount && this.fCurrency.equals(other.fCurrency);
    }

    @Override
    public int hashCode() {
        return 31 * Integer.hashCode(fAmount) + fCurrency.hashCode();
    }

    @Override
    public String toString() {
        return fAmount + " " + fCurrency;
    }
}
