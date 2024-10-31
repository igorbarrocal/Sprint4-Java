class Relatorio {
    private double valorGasto;
    private String problema;
    private String conserto;

    public Relatorio(double valorGasto, String problema, String conserto) {
        this.valorGasto = valorGasto;
        this.problema = problema;
        this.conserto = conserto;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getConserto() {
        return conserto;
    }

    public void setConserto(String conserto) {
        this.conserto = conserto;
    }

    @Override
    public String toString() {
        return "Relatorio{valorGasto=" + valorGasto + ", problema='" + problema + '\'' + ", conserto='" + conserto + '\'' + '}';

