package modele.operations;

import modele.exceptions.NonSupporteeException;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Operations {

    private String nomOperation;
    private Operations next;

    public Operations() {
    }

    public Operations(String nomOperation, Operations next) {
        this.nomOperation = nomOperation;
        this.next = next;
    }

    protected abstract double getResultat(double operande1, double operande2);

    public  double getResultat(String operation, double operande1, double operande2) throws NonSupporteeException {
        if (this.getNomOperation().equals(operation)) {
            return this.getResultat(operande1,operande2);
        }
        else {
            if (this.getNext()==null) {
                throw new NonSupporteeException();
            }
            else {
                return this.getNext().getResultat(operation,operande1,operande2);
            }
        }
    }

    public Collection<String> getOperations() {
        Collection<String> others;
        if (getNext() == null) {
            others= new ArrayList<String>();
        }
        else {
            others = getNext().getOperations();
        }
        others.add(getNomOperation());
        return others;
    }

    public String getNomOperation() {
        return nomOperation;
    }

    public void setNomOperation(String nomOperation) {
        this.nomOperation = nomOperation;
    }

    public Operations getNext() {
        return next;
    }

    public void setNext(Operations next) {
        this.next = next;
    }
}
