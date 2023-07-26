import hashlib
import time
import json

class BlockChain:
    def __init__(self):
        self.hashs = []     # List to store the hashes of blocks
        self.chain = []     # List to store the blocks
    
    def create_block(self, user_id, coin_name, value_trx, timestamp):
        if len(self.hashs) == 0:
            print('you should do hash first block')
        else:
            new_block = {'previous hash': self.hashs[-1], 'user id': user_id,
                         'coin name': coin_name, 'value trx': value_trx, 'timestamp': timestamp}
            self.chain.append(new_block)  # Add the new block to the chain
            # return new_block
    
    def add_block(self, user_id, coin_name, value_trx, timestamp):
        default_block = {'user id': user_id, 'coin name': coin_name,
                         'value trx': value_trx, 'timestamp': timestamp}
        self.chain.append(default_block)  # Add the default block to the chain
        return default_block
    
    def hash_block(self, whichblock):
        if whichblock == 'def':  # Default block
            to_str_ = json.dumps(self.chain[0])  # Convert the block to a JSON string
            first_hash = hashlib.sha256(to_str_.encode()).hexdigest()  # Calculate the SHA-256 hash of the JSON string
            self.hashs.append([first_hash])  # Add the hash to the list of hashes
            return first_hash
        
        elif whichblock == 'next':  # Second block and subsequent blocks
            to_str_ = json.dumps(self.chain[-1])  # Convert the last block to a JSON string
            next_hash = hashlib.sha256(to_str_.encode()).hexdigest()  # Calculate the SHA-256 hash of the JSON string
            self.hashs.append([next_hash])  # Add the hash to the list of hashes
            return next_hash
        
        else:
            return None
    
    def last_block(self):
        x = self.chain[-1]  # Get the last block from the chain
        return x

