import hashlib
import time
import json


class BlockChain:
    
    def __init__(self):
        self.hashs = []
        self.chain = []
    
    
    def create_block(self, user_id, coin_name, value_trx,timestamp):
        if len(self.hashs) == 0:
             print('you should do hash first block')
        else:
            
            new_block = {'previous hash':self.hashs[-1] ,'user id':user_id,
                           'coin name':coin_name,'value trx':value_trx,'timestamp':timestamp}
            self.chain.append(new_block)  
#             return new_block
    
    
    
    def add_block(self, user_id, coin_name, value_trx,timestamp):
        default_block = {'user id':user_id,
                       'coin name':coin_name,'value trx':value_trx,'timestamp':timestamp}
        self.chain.append(default_block)
        
        return default_block
    
    
    def hash_block(self, whichblock):
        if whichblock == 'def':  # Default block
            to_str_ = json.dumps(self.chain[0])
            first_hash = hashlib.sha256(to_str_.encode()).hexdigest()
            self.hashs.append([first_hash])
            return first_hash
        
        elif whichblock == 'next':  # Second block
            to_str_ = json.dumps(self.chain[-1])
            next_hash = hashlib.sha256(to_str_.encode()).hexdigest()
            self.hashs.append([next_hash])
            return next_hash
        
        else:
            return None
    
    
    
    def last_block(self):
        x = self.chain[-1]
        return x
    
    
