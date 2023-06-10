package org.aditya.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
public class UserRelations {

    HashMap<Integer, ArrayList<Integer>> followerMap = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> followeeMap = new HashMap<>();

    public void addUserRelations(User follower, User followee) {
        ArrayList<Integer> userIds = followerMap.getOrDefault(followee.getId(), new ArrayList<>());
        userIds.add(follower.getId());
        followerMap.put(followee.getId(), userIds);

        userIds = followeeMap.getOrDefault(follower.getId(), new ArrayList<>());
        userIds.add(follower.getId());
        followeeMap.put(follower.getId(), userIds);
    }

    public ArrayList<Integer> getUserFollowers(User user) {
        return followerMap.getOrDefault(user.getId(), new ArrayList<>());
    }

    public ArrayList<Integer> getUserFollowees(User user) {
        return followeeMap.getOrDefault(user.getId(), new ArrayList<>());
    }

    public void removeUserRelations(User follower, User followee) {
        ArrayList<Integer> userIds = followerMap.getOrDefault(followee.getId(), new ArrayList<>());
        userIds.removeIf(uId -> uId == follower.getId());
        followerMap.put(followee.getId(), userIds);

        userIds = followeeMap.getOrDefault(follower.getId(), new ArrayList<>());
        userIds.removeIf(uId -> uId == followee.getId());
        followeeMap.put(follower.getId(), userIds);
    }

}
