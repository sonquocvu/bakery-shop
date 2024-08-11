package com.sonvu.springboot.bakeryshop.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(FollowId.class)
@Table(name = "follow")
public class Follow {

	@Id
	@Column(name = "following_id")
	private Long followingId;
	
	@Id
	@Column(name = "follower_id")
	private Long followerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "following_id", insertable = false, updatable = false)
	private User following;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "follower_id", insertable = false, updatable = false)
	private User follower;
	
	public Follow()
	{
		
	}

	public Follow(Long followingId, Long followerId, User following, User follower) 
	{
		super();
		this.followingId = followingId;
		this.followerId = followerId;
		this.following = following;
		this.follower = follower;
	}

	public Long getFollowingId() 
	{
		return followingId;
	}

	public void setFollowingId(Long followingId) 
	{
		this.followingId = followingId;
	}

	public Long getFollowerId() 
	{
		return followerId;
	}

	public void setFollowerId(Long followerId) 
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
	private static final long serialVersionUID = 1L;
	private Long followingId;
	private Long followerId;
	
	public FollowId()
	{
		
	}
	
	public FollowId(Long followingId, Long followerId) 
	{
		this.followingId = followingId;
		this.followerId = followerId;
	}

	public Long getFollowingId() 
	{
		return followingId;
	}

	public void setFollowingId(Long followingId) 
	{
		this.followingId = followingId;
	}

	public Long getFollowerId() 
	{
		return followerId;
	}

	public void setFollowerId(Long followerId) 
	{
		this.followerId = followerId;
	}

    @Override
    public boolean equals(Object o) 
    {
        if (this == o)
        {
        	return true;
        }
        	
        if (o == null || getClass() != o.getClass())
        {
        	return false;
        }
        
        FollowId followId = (FollowId) o;
        
        return (Objects.equals(followingId, followId.followingId)
               && Objects.equals(followerId, followId.followerId));
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(followingId, followerId);
    }
}
