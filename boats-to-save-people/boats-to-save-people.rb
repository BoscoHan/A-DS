# @param {Integer[]} people
# @param {Integer} limit
# @return {Integer}
def num_rescue_boats(people, limit)
    people = people.sort {|a,b| a <=> b}   
    
    boats = 0
    i, j = 0, people.length-1
    
    #greedy approach
    while i <= j do 
        if people[i] + people[j] <= limit
            #if both lightest and heaviest can fit on one boat
            i+=1
            j-=1
        else      
            # can only take the heaviest person
            j-=1
        end     
        
        boats+=1
    end
    
    return boats
end
