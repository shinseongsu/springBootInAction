package com.example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberVO is a Querydsl query type for MemberVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberVO extends EntityPathBase<MemberVO> {

    private static final long serialVersionUID = -1851667732L;

    public static final QMemberVO memberVO = new QMemberVO("memberVO");

    public final ListPath<BoardVO, QBoardVO> boardList = this.<BoardVO, QBoardVO>createList("boardList", BoardVO.class, QBoardVO.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath role = createString("role");

    public QMemberVO(String variable) {
        super(MemberVO.class, forVariable(variable));
    }

    public QMemberVO(Path<? extends MemberVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberVO(PathMetadata metadata) {
        super(MemberVO.class, metadata);
    }

}

