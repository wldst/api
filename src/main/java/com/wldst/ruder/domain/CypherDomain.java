package com.wldst.ruder.domain;

public class CypherDomain extends SystemDomain {
    public static boolean isNeedAnd(StringBuilder sb) {
	String cypher = sb.toString();
	return isNeedAnd(cypher);
    }

    public static boolean isNeedAnd(String cypher) {
	boolean needAppendAnd = !cypher.trim().endsWith(" and")&& 
				!cypher.trim().endsWith(" where")&&
				!cypher.trim().endsWith(" WHERE")&&
				!cypher.trim().endsWith(" AND");
	return needAppendAnd;
    }
}
