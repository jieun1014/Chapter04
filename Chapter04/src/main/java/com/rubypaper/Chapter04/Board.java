package com.rubypaper.Chapter04;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Table(name = "BOARD")
@TableGenerator(name = "BOARD_SEQ_GENERATOR",
				table = "ALL_SEQUENCES",
				pkColumnValue = "BOARD_SEQ",
				initialValue = 0,
				allocationSize = -1)
public class Board implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	private Long seq;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(nullable = false)
	private Long cnt;
	
	@Transient
	private String exceptValue;
	
	
	
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
	
	
   
}
