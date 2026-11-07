public abstract class Entity
{
    private final static int MAX_HP = 100;
    private final int DEFAULT_HP = 100;
    private final int DEFAULT_ATTACK_POWER = 15;
    private final int RANDOM_MODIFIER_MAX = 5;

    private int _hp;
    private int _attackPower;

    public static int getMaxHp()
    {
        return MAX_HP;
    }

    public Entity()
    {
        _hp = DEFAULT_HP;
        _attackPower = DEFAULT_ATTACK_POWER;
    }

    public boolean isAlive()
    {
        return _hp > 0;
    }

    public int getHp()
    {
        return _hp;
    }

    public void setHp(int hp)
    {
        if (hp > 100 || hp < 0) _hp = DEFAULT_HP;
        _hp = hp;
    }

    public int getAttackPower()
    {
        return _attackPower;
    }

    public void setAttackPower(int attackPower)
    {
        _attackPower = attackPower;
    }

    public void attack(Entity other)
    {
        int damage = _attackPower + (int)(Math.random() * (RANDOM_MODIFIER_MAX + 1));

        if (other._hp - damage < 0)
        {
            other._hp = 0;
            return;
        }
        other._hp -= damage;
    }
}
