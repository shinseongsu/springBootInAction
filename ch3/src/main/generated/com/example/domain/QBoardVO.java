package com.example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardVO is a Querydsl query type for BoardVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardVO extends EntityPathBase<BoardVO> {

    private static final long serialVersionUID = 1952840934L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardVO boardVO = new QBoardVO("boardVO");

    public final NumberPath<Long> cnt = createNumber("cnt", Long.class);

    public final StringPath content = createString("content");

    public final DatePath<java.util.Date> createDate = createDate("createDate", java.util.Date.class);

    public final QMemberVO member;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QBoardVO(String variable) {
        this(BoardVO.class, forVariable(variable), INITS);
    }

    public QBoardVO(Path<? extends BoardVO> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardVO(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardVO(PathMetadata metadata, PathInits inits) {
        this(BoardVO.class, metadata, inits);
    }

    public QBoardVO(Class<? extends BoardVO> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMemberVO(forProperty("member")) : null;
    }

}

