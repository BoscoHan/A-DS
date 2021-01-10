# @param {String[]} word1
# @param {String[]} word2
# @return {Boolean}
def array_strings_are_equal(word1, word2)
​
    firstWord = ""
    word1.each do |subStr|
        firstWord += subStr
    end
    
    secondWord = ""
    word2.each do |subStr|
       secondWord += subStr 
    end
    
    return firstWord.eql?(secondWord)
end
