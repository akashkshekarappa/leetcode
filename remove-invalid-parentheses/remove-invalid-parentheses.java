                
                if(!flag){
                    // if flag = false, means no string is valid, add child nodes in to queue to process next level
                    // hence we remove 1 parentheses from current string and add to queue if not visited
                    for(int j=0; j<current.length(); j++){
                        char c = current.charAt(j);
                        if(Character.isLetter(c))  //skip if character is letter
                            continue;
                        
                        else{   //else create a child string without character c and add to queue if not visited
                            String child = current.substring(0, j) + current.substring(j + 1);
                            if(!visited.contains(child)){
                                q.add(child);
                                visited.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String current){
        int count = 0;
        for(int i=0; i<current.length(); i++){
             char c = current.charAt(i);
                if(Character.isLetter(c))
                    continue;
                else if(c == '(')
                    count++;
                else {  // if c == ')'
                    if(count > 0)
                        count--;
                    else
                        return false;       
                }
            }
        return count == 0;
    }
}
