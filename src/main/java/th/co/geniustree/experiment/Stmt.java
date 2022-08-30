package th.co.geniustree.experiment;

import java.util.List;

public sealed interface Stmt {
    interface Visitor<R> {
        R visitExpressionStmt(Expression stmt);

        R visitPrintStmt(Print stmt);

        R visitVarStmt(Var var);

        R visitBlockStmt(Block block);

        R visitIfStmt(If anIf);

        R visitWhileStmt(While aWhile);
    }

    abstract <R> R accept(Stmt.Visitor<R> visitor);

    record Expression(Expr expression) implements Stmt {
        @Override
        public <R> R accept(Stmt.Visitor<R> visitor) {
            return visitor.visitExpressionStmt(this);
        }
    }

    record Print(Expr expression) implements Stmt {
        @Override
        public <R> R accept(Stmt.Visitor<R> visitor) {
            return visitor.visitPrintStmt(this);
        }
    }

    record Var(Token name, Expr initializer) implements Stmt {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVarStmt(this);
        }
    }

    record Block(List<Stmt> statements) implements Stmt {

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStmt(this);
        }
    }

    record If(Expr condition, Stmt thenBranch, Stmt elseBranch) implements Stmt {

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitIfStmt(this);
        }
    }

    record While(Expr condition, Stmt body) implements Stmt {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhileStmt(this);
        }
    }
}
