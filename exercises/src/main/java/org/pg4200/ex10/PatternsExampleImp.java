package org.pg4200.ex10;

public class PatternsExampleImp implements PatternExamples {
    @Override
    public String dnaRegex() {
        return "[CGAT]+";
    }

    @Override
    public String telephoneNumberRegex() {
        return "((\\+|00)[0-9]{2})?[0-9]{8}";
    }

    @Override
    public String emailRegex() {
        return "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
    }

    @Override
    public String isItAJoke() {
        //return "[Ii][Ss] +[Tt][Hh][Ii][Ss] +[Aa][Nn] +[Oo][Uu][Tt] +[Oo][Ff] +[Ss][Ee][Aa][Ss][Oo][Nn] +[Aa][Pp][Er][Ii][Ll] +[Ff][Oo][Oo][Ll][Ss]+\\'? +[Jj][Oo][Kk][Ee]\\?";
        return "[Ii][Ss]\\s+[Tt][Hh][Ii][Ss]\\s+[Aa][Nn]\\s+[Oo][Uu][Tt]\\s+[Oo][Ff]\\s+[Ss][Ee][Aa][Ss][Oo][Nn]\\s+[Aa][Pp][Rr][Ii][Ll]\\s+[Ff][Oo][Oo][Ll][Ss]+\\'?\\s+[Jj][Oo][Kk][Ee]\\?";
    }
}
