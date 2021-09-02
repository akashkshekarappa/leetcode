//Time complexity: O(1)
//Space Complexity: O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
        float h = (hour % 12 + (float)minutes/60) * 30;    //position of hour, 360 deg / 12 hours = 30 degrees per hours
        float m = minutes * 6;  //position of minutes, 360/60
        float angle = Math.abs(h - m);
        
        if(angle > 180)
            angle = 360 - angle;
        
        return angle;
    }
}