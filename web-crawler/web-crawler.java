/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
​
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String hostname = getHostName(startUrl);
        
        q.add(startUrl);
        set.add(startUrl);
        
        while(!q.isEmpty()){
            String curr = q.poll();
            
            for(String url: htmlParser.getUrls(curr)){
                if(url.contains(hostname) && !set.contains(url)){
                    q.add(url);
                    set.add(url);
                }
            }
        }
        return new ArrayList<>(set);
    }
    
    private String getHostName(String url){
        String[] str = url.split("/");
        return str[2];
    }
}
