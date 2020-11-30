/**
 * @author Zixiang Hu
 * @description
 * @create 2020-08-29-20:13
 */
public class Test2 {
    public static String helper(String st) {
        if (st == null || st.length() == 0)
            return st;
        int i = 0;
        while (i < st.length() && st.charAt(i) == '_')
            i++;
        st = st.substring(i);
        int j = st.length() - 1;
        while (j >= 0 && st.charAt(j) == '_') {
            j--;
        }
        st = st.substring(0, j + 1);
        st = st.replaceAll("_{1,}", "_");
        return st;
    }

    public static void main(String[] args) {
        String st = "__aa__b____vc__d__";
   /*     char[] str = st.toCharArray();
        int i=0,j=0;
        while(str[i]=='_'){
            i++;
        }
        while(i<=str.length-1){
            if(str[i]=='_'&&(i==str.length-1||str[i+1]=='_')){ //如果中间空格的之后还存在空格的话，或者是结尾的话。
                i++;
                continue;
            }
            str[j++]=str[i++];
        }
        for(int o=0;o<j;o++){
            System.out.print(str[o]);
        }*/


       /* st = helper(st);
        System.out.println(st);*/

    }
}
