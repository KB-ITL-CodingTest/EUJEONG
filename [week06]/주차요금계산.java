import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, List<String>> info = new HashMap<>();//(차량,차량별로 입출차 기록을 저장한 리스트)를 쌍으로 갖는 해쉬맵
        for(String record:records){
            String time_info[] = record.split(" ");
            String time = time_info[0];
            String car = time_info[1];
            String state = time_info[2];
            
            if(info.containsKey(car)){//차량 정보가 이미 있으면 이후 입출차 기록 추가하기
                info.get(car).add(time);
            }else{//차량 정보가 없으면 해당 차량에 대한 리스트 새로 할당한 후 입출차 기록 추가하기
                info.put(car,new ArrayList<>());
                info.get(car).add(time);
            }
        }
        
        Map<String,Integer> total_time = new HashMap<>(); //차량별로 총 소요 시간 저장한 해쉬맵
        
        for(Map.Entry<String,List<String>> e : info.entrySet()){//차량별로 총 소요시간 저장하기
            String car = e.getKey();//키
            List<String> time_list = e.getValue();//값
            int due_time = 0;//한 번 입차 ~ 출차까지의 경과 시간
            
            if(time_list.size()%2==1)time_list.add("23:59"); //마지막에 출차한 기록이 없다면 23:59에 출차한 것으로 간주하고 추가하기
            for(int i=0;i<time_list.size()/2;i++){
                String[] hour_minute1 = time_list.get(i*2).split(":");
                String[] hour_minute2 = time_list.get(i*2+1).split(":");
                
                int in_time = Integer.valueOf(hour_minute1[0])*60 + Integer.valueOf(hour_minute1[1]); //입차한 시간
                int out_time = Integer.valueOf(hour_minute2[0])*60 + Integer.valueOf(hour_minute2[1]); //출차한 시간
                due_time += out_time-in_time;
                
            }
            total_time.put(car,due_time); //해당 차량에 대한 총 소요시간 저장하기
        }
        
        Map<String,Integer> answer_map = new TreeMap<>();
        for(Map.Entry<String,Integer> e : total_time.entrySet()){//각 차량별로 주차 요금 계산하기
            String car = e.getKey();
            int time = e.getValue();
            int basic_time = fees[0];//기본시간
            int basic_fee = fees[1];//기본요금
            int per_time = fees[2];//단위시간
            int per_fee = fees[3];//단위요금
            int total_fee = 0;
            if(time<basic_time){
                //경과 시간이 기본 시간 이하라면 그냥 기본 요금
                total_fee = basic_fee;
                answer_map.put(car,total_fee);
            }else{
                int extra_time = time - basic_time;
                total_fee = basic_fee;
                if(extra_time%per_time!=0){
                    //초과한 시간이 단위 시간으로 나누어 떨어지지 않으면
                    //올림하기
                    total_fee+=(((extra_time/per_time)+1)*per_fee);
                }else{
                    total_fee+=((extra_time/per_time)*per_fee);
                }
                answer_map.put(car,total_fee);
            }
        }
        answer = new int[answer_map.size()];
        int i=0;
        for(Map.Entry<String,Integer> e : answer_map.entrySet()){
            answer[i]=e.getValue();
            i+=1;
        }
        return answer;
    }
}
