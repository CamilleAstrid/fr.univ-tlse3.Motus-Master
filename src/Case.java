public enum Case {
    // Enumération des différentes cases possibles correspondant à l'alphabet
    A("A"), B("B"), C("C"), D("D"), E("E"),
    F("F"), G("G"), H("H"), I("I"), J("J"),
    K("K"), L("L"), M("M"), N("N"), O("O"),
    P("P"), Q("Q"), R("R"), S("S"), T("T"),
    U("U"), V("V"), W("W"), X("X"), Y("Y"),
    Z("Z"), VIDE(" ");

    private String symbole;

    private Case(String symbole){
        this.symbole = symbole;
    }

    public String getSymbole(){
        return symbole;
    } 
}
