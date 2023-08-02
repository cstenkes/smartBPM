package com.brevissimus.smartbpm.model.base;

import java.util.Comparator;

import com.brevissimus.smartbpm.model.Node;

public class NodeComaparator implements Comparator<Node>{

    public int compare(Node o1, Node o2) {
        if (o1==null && o2==null){
            return 0;
        }
        else if (o1==null && o2!=null ){
            return 1;
        }
        else if (o1!=null && o2==null ){
            return -1;
        }
        return Long.signum(o1.getId()-o2.getId());
    }

}

