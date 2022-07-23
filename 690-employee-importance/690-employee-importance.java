/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> hm = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            hm.put(employees.get(i).id, employees.get(i));
        }
        return dfs(id, hm);
    }
    
    public int dfs(int id, Map<Integer, Employee> hm) {
        if (hm.get(id).subordinates.size() == 0) {
            return hm.get(id).importance;
        }
        
            Employee e = hm.get(id);
            int sum = e.importance;
            for (int i: e.subordinates) {
                sum += dfs(i, hm);
            }
            return sum;
        
    }
    
}