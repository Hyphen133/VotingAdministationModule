package app.services;

import app.contracts.VoteManager;
import app.domain.Ballot;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class BallotStartupServices {

    VoteManager voteManager;

    public BallotStartupServices() {
        //https://github.com/web3j/web3j/issues/332
        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
        String account = null;
        try {
            account = web3j.ethAccounts().send().getAccounts().get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Credentials credentials = Credentials.create(account);
        TransactionManager transactionManager = new ClientTransactionManager(web3j, "");
        voteManager = VoteManager.load("0x8b0295813d84bdeb33857780d323a742679e264e", web3j, new ClientTransactionManager(web3j,"0xb59994635608b2f2e816d77522635e56f14e0312"), new DefaultGasProvider() );



    }

    public void startTimerForBallot(Ballot ballot) {
        System.out.println("Started Timer");
        BallotTimer timer = new BallotTimer(this, ballot);
        timer.start();
    }


    public void startBallot(Ballot ballot) {
        try {
            RemoteCall<TransactionReceipt> call = voteManager.createBallot(ballot.getParticipants().getCandidates().stream().map(x -> stringToBytes32(x.getName())).collect(Collectors.toList()),
                    ballot.getParticipants().getUsers().stream().map(x -> BigInteger.valueOf(x.getId())).collect(Collectors.toList()));
            call.send();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        RemoteCall<BigInteger> lastBallotId = voteManager.lastBallotIndex();
//
//        try {
//            ballot.setId(lastBallotId.send().intValue());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public void endBallot(Ballot ballot) {
        voteManager.endBallot(BigInteger.valueOf(ballot.getId()));
    }


    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
    }

    public static byte[] stringToBytes32(String string) {
        byte[] byteValue = string.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return byteValueLen32;
    }
}
