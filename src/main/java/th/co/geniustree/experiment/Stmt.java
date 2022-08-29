package th.co.geniustree.experiment;

public sealed interface Stmt {
    interface Visitor<R> {
        R visitExpressionStmt(Expression stmt);
        R visitPrintStmt(Print stmt);
    }
    abstract <R> R accept(Stmt.Visitor<R> visitor);
    record Expression(Expr expression) implements Stmt{
        @Override
        public <R> R accept(Stmt.Visitor<R> visitor) {
            return visitor.visitExpressionStmt(this);
        }
    }
    record Print(Expr expression) implements Stmt{
        @Override
        public <R> R accept(Stmt.Visitor<R> visitor) {
            return visitor.visitPrintStmt(this);
        }
    }
}
