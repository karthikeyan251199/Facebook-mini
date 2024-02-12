package com.chainsys.socialmedia.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "postid")
    @SequenceGenerator(name = "postid", sequenceName = "postid",  allocationSize = 1)
	@Column(name="postid")
	private int postId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="posttype")
	private byte[] postType;
	
	@Column(name="medialocation")
	@Size(max = 40, min = 3, message = "*Location length should be 3 to 40")
	@NotBlank(message = "*Location can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,40}$", message = "*Enter valid Location ")
	private String mediaLocation;
	
	@Size(max = 20, min = 3, message = "*Visibility length should be 3 to 20")
	@NotBlank(message = "*Visibility can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,20}$", message = "*Enter valid Visibility ")
	private String visibility;

	private String dates;
	
	private String times;
	
	@Column(name="likecount")
	private int likeCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Like> Like;
	
	public List<Like> getLike() {
		return Like;
	}
	public void setLike(List<Like> like) {
		Like = like;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public byte[] getPostType() {
		return postType;
	}
	public void setPostType(byte[] postType) {
		this.postType = postType;
	}
	public String getMediaLocation() {
		return mediaLocation;
	}
	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public String getDates() {
		return dates;
	}
	public void setDates() {
		Calendar vCalendar = Calendar.getInstance();
		String date =  vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR);
		this.dates = date;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes() {
		Calendar vCalendar = Calendar.getInstance();
		String time = vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.times = time;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
