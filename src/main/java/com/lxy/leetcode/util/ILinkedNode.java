package com.lxy.leetcode.util;

public interface ILinkedNode<TNode extends ILinkedNode<TNode>> {
    boolean equals(TNode other);

    TNode next();

    boolean isNull();
}
