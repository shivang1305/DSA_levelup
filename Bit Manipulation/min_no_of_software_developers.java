/*
    DSA LEVELUP - Bit Manipulation                                              Date: 23-Feb-2021

1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is 
   at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.
*/

import java.util.*;

public class min_no_of_software_developers {
    static ArrayList<Integer> sol = new ArrayList<>();

    public static void solution(int[] people, int nSkills, int currPerson, ArrayList<Integer> oneSol, int skillsMask) {
        // base case
        if(currPerson == people.length) {
            if(skillsMask == (1 << nSkills) - 1) { // checking that all the required skills are covered or not
                if(sol.size() == 0 || oneSol.size() < sol.size()) { // only considering it as the final ans if its size is least
                    sol = new ArrayList<>(oneSol);
                }
            }
            return;
        }

        solution(people, nSkills, currPerson + 1, oneSol, skillsMask); // no ki call

        // yes ki call
        oneSol.add(currPerson); // adding the index of current person in the solution before making the call to the recursive func (pre)
        solution(people, nSkills, currPerson + 1, oneSol, (skillsMask | people[currPerson]));
        oneSol.remove(oneSol.size() - 1);// removing the index of current person from the solution after making the call to the recursive func (post) undo while backtracking
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of skills

        HashMap<String, Integer> skillsMap = new HashMap<>();

        // mapping each skill with a number 
        for(int i = 0; i < n; i++) {
            skillsMap.put(scn.next(), i);
        }

        int persons = scn.nextInt(); // number of persons

        int[] people = new int[persons];

        for(int i = 0; i < persons; i++) { 
            int noOfSkills = scn.nextInt(); // no of skills that person has
            for(int j = 0; j < noOfSkills; j++) {
                String skill = scn.next(); // skill which the person has
                int skillNum = skillsMap.get(skill); // getting the number of that skill from the skill map 

                people[i] = people[i] | (1 << skillNum); // building the skill mask
            }
        }

        scn.close();
        
        solution(people, n, 0, new ArrayList<>(), 0);
    }
}
