package leetcode;

import java.util.Stack;//java中自带的栈

public class Solution3 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i<ops.length;i++){

            switch (ops[i]){
                case "C":stack.pop();break;
                case "D":int a=stack.pop();stack.push(a); ;stack.push(a+a);break;
                case "+":int c=stack.pop();int b=stack.pop();stack.push(b);stack.push(c);stack.push(c+b);break;
                default:stack.push(Integer.parseInt(ops[i]));break;
            }
        }

        int total=0;
        while (stack.empty()==false){
            total+=stack.pop();
        }
        return total;
    }
    public static void main(String args[]){
        String a[] = new String[]{"5","2","C","D","+"};
       // System.out.println(Integer.parseInt());
        Solution3 s=new Solution3();
        s.calPoints(a);
    }
}

/*
* java.security.AccessControlException: access denied ("java.util.PropertyPermission" "5" "read")
  at line 472, java.security.AccessControlContext.checkPermission
  at line 884, java.security.AccessController.checkPermission
  at line 549, java.lang.SecurityManager.checkPermission
  at line 1294, java.lang.SecurityManager.checkPropertyAccess
  at line 717, java.lang.System.getProperty
  at line 1101, java.lang.Integer.getInteger
  at line 1011, java.lang.Integer.getInteger
  at line 10, Solution.calPoints
  at line 54, __DriverSolution__.__helper__
  at line 79, __Driver__.main*/
