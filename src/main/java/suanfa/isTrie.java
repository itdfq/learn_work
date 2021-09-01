package suanfa;

import java.util.HashMap;

public class isTrie {

    public static void main(String[] args) {
        Tries tries=new Tries();
        String strs[]={"abc","abd","b","abdc"};

        for(int i=0;i<strs.length;i++)
            insertNode(strs[i], tries);
    }


    public static boolean insertNode(String str,Tries head)
    {
        if(str==null||str.length()==0)
            return false;
        char chs[]=str.toCharArray();
        int i=0;
        Tries cur=head;
        while(i<chs.length)
        {
            if(!cur.children.containsKey(chs[i]))
            {

                cur.children.put(chs[i], new Tries());
            }
            cur=cur.children.get(chs[i]);
            if(cur.count==true)
            {
                System.out.println(" trie tree");
                return true;
            }
            i++;
        }
        cur.count=true;
        if(cur.children.size()>0)
        {
            System.out.println(" trie tree");
            return true;
        }
        return false;
    }
}
class Tries{
    public boolean count;
    boolean isTrie;
    HashMap<Character, Tries> children=new HashMap<Character, Tries>();
}