import java.util.*;

class Solution {
    Map<String, User> users = new HashMap<>();
    
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        
        for(String s : record){
            String[] contents = s.split(" ");
            
            User user = getUserByUId(getUIDFromRecord(s));
            if(user != null){
                users.get(user.getUserId()).setName(getNameFromRecord(s, user.getName()));
            } else {
                users.put(contents[1], makeUser(s, ""));
            }
        }
        for(String s : record){
            String[] contents = s.split(" ");
            State state = State.valueOf(contents[0]);
            if (!state.equals(State.Change)) {
                User user = getUserByUId(contents[1]);
                result.add(user.getName() + "님이 " + state.getMessage());
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    public User getUserByUId(String userId){
        if(users.containsKey(userId)){
            return users.get(userId);
        } else {
            return null;
        }
    }
    
    public User makeUser(String record, String originalName){
        String[] contents = record.split(" ");
        State state = State.valueOf(contents[0]);
        return new User(state, contents[1], contents.length > 2 ? contents[2] : originalName);
    }
    
    public String getNameFromRecord(String record, String originalName){
        String[] contents = record.split(" ");
        return contents.length > 2 ? contents[2] : originalName;
    }
    
    public String getUIDFromRecord(String record){
        String[] contents = record.split(" ");
        return contents[1];
    }
    
    public static class User {
        private State state;
        private String userId;
        private String name;
        
        public User(State state, String userId, String name){
            this.userId = userId;
            this.name = name;
            this.state = state;
        }
        
        public String getUserId(){
            return this.userId;
        }
        
        public String getName(){
            return this.name;
        }
        
        public State getState(){
            return this.state;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public void setState(State state){
            this.state = state;
        }
        
        public boolean equals(Object o){
            if(o == this){
                return true;
            }
            if(o instanceof User){
                User user = (User) o;
                if(user.getUserId().equals(this.getUserId())){
                    return true;
                }
            }
            return false;
        }
        public String toString(){
            return this.state + " " +
                this.userId + " " + 
                this.name;
        }
    }
    
    public static enum State{
        Enter("들어왔습니다."),
        Leave("나갔습니다."),
        Change("");
        
        private final String message;
        
        State(String message){
            this.message = message;
        }
        
        public String getMessage() {
            return this.message;
        }
    }
}