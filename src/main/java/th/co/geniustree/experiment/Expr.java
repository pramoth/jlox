package th.co.geniustree.experiment;

import java.util.List;

public sealed interface Expr {
    static interface Visitor<R> {
        R visitBinaryExpr(Binary expr);

        R visitGroupingExpr(Grouping groouping);

        R visitLiteralExpr(Literal expr);

        R visitUnaryExpr(Unary expr);

        R visitVariableExpr(Variable variable);

        R visitAssignExpr(Assign assign);

        R visitLogicalExpr(Logical logical);

        R visitCallExpr(Call call);

        R visitGetExpr(Get get);

        R visitSetExpr(Set set);

        R visitThisExpr(This expr);
    }

    abstract <R> R accept(Visitor<R> visitor);

    record Binary(Expr left, Token operator, Expr right) implements Expr {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBinaryExpr(this);
        }
    }

    record Grouping(Expr expression) implements Expr {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitGroupingExpr(this);
        }
    }

    record Literal(Object value) implements Expr {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitLiteralExpr(this);
        }
    }

    record Unary(Token operator, Expr right) implements Expr {
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnaryExpr(this);
        }
    }

    record Variable(Token name) implements Expr {

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVariableExpr(this);
        }
    }

    record Assign(Token name, Expr value) implements Expr {

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitAssignExpr(this);
        }
    }

    record Logical(Expr left, Token operator, Expr right) implements Expr {

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitLogicalExpr(this);
        }
    }
    record Call(Expr callee, Token paren, List<Expr> arguments) implements Expr{

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitCallExpr(this);
        }
    }
    record Get(Expr object,Token name) implements Expr{

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitGetExpr(this);
        }
    }
    record Set(Expr object, Token name, Expr value) implements Expr{

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitSetExpr(this);
        }
    }
    record This(Token keyword) implements Expr{
        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitThisExpr(this);
        }
    }
}
