package banco;

public class ContaCorrente {

    public int numcont;
    public String nomecont;
    public int saldocont;
    public int especialcont;

    public void ContaCorrente() {

    }

    public void setNumcont(int numcont) {
        this.numcont = numcont;
    }

    public void setNomecont(String nomecont) {
        this.nomecont = nomecont;
    }

    public void setSaldocont(int saldocont) {
        this.saldocont = saldocont;
    }

    public void setEspecialcont(int especialcont) {
        this.especialcont = especialcont;
    }

    public int getNumcont() {
        return numcont;
    }

    public String getNomecont() {
        return nomecont;
    }

    public int getSaldocont() {
        return saldocont;
    }

    public int getEspecialcont() {
        return especialcont;
    }

    public ContaCorrente(int numcont, String nomecont, int saldocont, int especialcont) {
        this.numcont = numcont;
        this.nomecont = nomecont;
        this.saldocont = saldocont;
        this.especialcont = especialcont;
    }

    public void Deposito(int valor) {
        if (this.especialcont >= 100) {
            int Novo_saldo = this.saldocont + valor;
            this.saldocont = Novo_saldo;
        } else if ((valor - (100 - this.especialcont)) >= 0) {
            int Novo_saldo = this.saldocont - (100 - this.especialcont);
            this.especialcont = 100;
            this.saldocont = Novo_saldo;
        } else if ((valor + this.especialcont) < 100) {
            int Novo_saldo = this.especialcont + valor;
            this.especialcont = Novo_saldo;
        }

    }
    
    public void Imprime(){
        System.out.printf("%d \t %s \t \t %d  \n", this.numcont,this.nomecont, this.saldocont);
    }
    
    public void saque(int valor){
        if ((this.saldocont - valor) >=0){
            this.saldocont = this.saldocont - valor;
            System.out.println("++ saque Efetuado ++");
        }
        else if ((this.saldocont + this.especialcont) >= valor) {
            this.especialcont = (this.saldocont + this.especialcont) - valor;
            this.saldocont = 0;
            System.out.println("++ saque Efetuado com uso do cheque especial ++");
        }
        else{
            System.out.println(" ---  Saldo Insuficiente -- ");
        }
    }
    public boolean Tem_Saldo(int valor){
        return((this.saldocont - valor) >=0 || (this.saldocont + this.especialcont) >= valor );

    }
    
}
