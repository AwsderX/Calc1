//Калькулятор арифметических формул.
public class Calc extends Compf {
    private StackInt s;
    public Integer q = 0;
    public String y;
    public String w;
    public String e;
    public String r;

    private static int char2int(char c) {
        return (int) c - (int) '0';
    }

    @Override
    protected int symOther(char c) {
        if (c < '0' || c > '7') {
            System.out.println("Недопустимый символ: " + c);

            System.exit(0);
        }

        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();

        switch (c) {
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first * second);
                break;
            case '/':
                s.push(first / second);
                break;
        }
    }

    @Override
    protected void nextOther(char c) {
        if (a) {
            s.push(s.pop() * 8 + char2int(c));
        } else {
            s.push(char2int(c));
            a = true;
        }
        //s.push(Character.getNumericValue(c));
    }

    public Calc() {
        s = new StackInt();
    }

    public final void compile(char[] str) {
        super.compile(str);
        //q = qwerty(s.top());
        q=s.top();
        System.out.println(q);
        convert();
        System.out.println(y);
    }

    //public int qwerty(int x) {
     //   x = x % 10 + x % 100 / 10 * 8 + x % 1000 / 100 * 64 + x % 10000 / 1000 * 512;
      //  return x;
   // }

    public String convert() {
            switch ((q % 10000) / 1000) {
                case 1: y = "M"; break;
                case 2: y = "MM"; break;
                case 3: y = "MMM"; break;
                default: y = ""; break;
            }
            switch ((q % 1000)/100) {
                case 1: w = "C"; break;
                case 2: w = "CC"; break;
                case 3: w = "CCC"; break;
                case 4: w = "CD"; break;
                case 5: w = "D"; break;
                case 6: w = "DC"; break;
                case 7: w = "DCC"; break;
                case 8: w = "DCCC"; break;
                case 9: w = "CM"; break;
                default: w = ""; break;
            }
            switch ((q % 100)/ 10) {
                case 1: e = "X"; break;
                case 2: e = "XX"; break;
                case 3: e = "XXX"; break;
                case 4: e = "XL"; break;
                case 5: e = "L"; break;
                case 6: e = "LX"; break;
                case 7: e = "LXX"; break;
                case 8: e = "LXXX"; break;
                case 9: e = "XC"; break;
                default: e = ""; break;
            }
            switch (q % 10) {
                case 1: r = "I"; break;
                case 2: r = "II"; break;
                case 3: r = "III"; break;
                case 4: r = "IV"; break;
                case 5: r = "V"; break;
                case 6: r = "VI"; break;
                case 7: r = "VII"; break;
                case 8: r = "VIII"; break;
                case 9: r = "IX"; break;
                default: r = ""; break;
            }
            y = y + w + e + r;





        return y;
}
}
