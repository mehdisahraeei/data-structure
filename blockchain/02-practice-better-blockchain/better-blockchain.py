import hashlib
import json
import time

class BlockChain:
    
    def __init__(self):
        self.chain = []
    
    
    def creating_new_block(self, user_id, coin_name, value_trx):
        if not self.chain: # if len(self.chain) == 0: 
            print('You should create the first block and do hash default chain ')
        else:
            new_block = {
                'previous_hash': self.hash_block(self.chain[-1]),
                'user_id': user_id,
                'coin_name': coin_name,
                'value_trx': value_trx,
                'timestamp': time.time()
            }
            self.chain.append(new_block)
            return new_block
    
    
    def adding_first_block(self, user_id, coin_name, value_trx):
        
        default_block = {'user_id': user_id,'coin_name': coin_name,
                             'value_trx': value_trx,'timestamp': time.time()}    
        self.chain.append(default_block)
        return default_block
    
    
    def hash_block(self,block):
        to_str_ = json.dumps(block, sort_keys=True)
        return hashlib.sha256(to_str_.encode()).hexdigest()
    
    
    def last_block(self):
        if not self.chain:
            return None
        return self.chain[-1]

