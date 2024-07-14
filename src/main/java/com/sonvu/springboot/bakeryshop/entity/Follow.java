package com.sonvu.springboot.bakeryshop.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(FollowId.class)
@Table(name = "follow_tbl")
public class Follow {

	@Id
	private Integer followingId;
	
	@Id
	private Integer followerId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User following;
	
	@ManyToOne
	@JoinColumn(name = "user_id_followed", insertable = false, updatable = false)
	private User follower;
	
	public Follow()
	{
		
	}

	public Follow(Integer followingId, Integer followerId, User following, User follower) 
	{
		super();
		this.followingId = followingId;
		this.followerId = followerId;
		this.following = following;
		this.follower = follower;
	}

	public Integer getFollowingId() 
	{
		return followingId;
	}

	public void setFollowingId(Integer followingId) 
	{
		this.followingId = followingId;
	}

	public Integer getFollowerId() 
	{
		return followerId;
	}

	public void setFollowerId(Integer followerId) 
	{
		this.followerId = followerId;
	}

	public User getFollowing() 
	{
		return following;
	}

	public void setFollowing(User following) 
	{
		this.following = following;
	}

	public User getFollower() 
	{
		return follower;
	}

	public void setFollower(User follower) 
	{
		this.follower = follower;
	}
	
}

class FollowId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7549587292231051924L;
	private Integer followingId;
	private Integer followerId;
	
	public FollowId()
	{
		
	}
	
	public FollowId(Integer followingId, Integer followerId) 
	{
		super();
		this.followingId = followingId;
		this.followerId = followerId;
	}

	public Integer getFollowingId() 
	{
		return followingId;
	}

	public void setFollowingId(Integer followingId) 
	{
		this.followingId = followingId;
	}

	public Integer getFollowerId() 
	{
		return followerId;
	}

	public void setFollowerId(Integer followerId) 
	{
		this.followerId = followerId;
	}

}
