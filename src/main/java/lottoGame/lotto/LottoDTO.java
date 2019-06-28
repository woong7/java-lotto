package lottoGame.lotto;

public class LottoDTO {
    private int idx;
    private int no1;
    private int no2;
    private int no3;
    private int no4;
    private int no5;
    private int no6;
    private int token;
    private boolean isAuto;

    public LottoDTO(int idx, int no1, int no2, int no3, int no4, int no5, int no6, int token, boolean isAuto) {
        this.idx = idx;
        this.no1 = no1;
        this.no2 = no2;
        this.no3 = no3;
        this.no4 = no4;
        this.no5 = no5;
        this.no6 = no6;
        this.token = token;
        this.isAuto = isAuto;
    }

    public int getIdx() {
        return idx;
    }

    public int getNo1() {
        return no1;
    }

    public int getNo2() {
        return no2;
    }

    public int getNo3() {
        return no3;
    }

    public int getNo4() {
        return no4;
    }

    public int getNo5() {
        return no5;
    }

    public int getNo6() {
        return no6;
    }

    public int getToken() {
        return token;
    }

    public boolean isAuto() {
        return isAuto;
    }
}
