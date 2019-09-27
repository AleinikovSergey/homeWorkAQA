import java.util.Objects;

public class functionResult {
    String operation;
    String oneParam;
    String twoParam;
    String result;
    String error;

    @Override
    public String toString() {
        return "functionResult{" +
                "operation='" + operation + '\'' +
                ", oneParam='" + oneParam + '\'' +
                ", twoParam='" + twoParam + '\'' +
                ", result='" + result + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        functionResult that = (functionResult) o;
        return Objects.equals(operation, that.operation) &&
                Objects.equals(oneParam, that.oneParam) &&
                Objects.equals(twoParam, that.twoParam) &&
                Objects.equals(result, that.result) &&
                Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, oneParam, twoParam, result, error);
    }

    public functionResult() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public functionResult(String error) {
        this.error = error;
    }

    public functionResult(String operation, String oneParam, String twoParam, String result) {
        this.operation = operation;
        this.oneParam = oneParam;
        this.twoParam = twoParam;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOneParam() {
        return oneParam;
    }

    public void setOneParam(String oneParam) {
        this.oneParam = oneParam;
    }

    public String getTwoParam() {
        return twoParam;
    }

    public void setTwoParam(String twoParam) {
        this.twoParam = twoParam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}

